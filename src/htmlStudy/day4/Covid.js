let serviceKey = "hU1pT%2Bq4rSsCEbJYjtv1Gqctta4YxYeI7ZAxFth%2BmtTUu%2FyMoxj4IZRZc9ADM8DEr8PkQC7EmCJjd%2FEjSaFFUg%3D%3D";

var xhr = new XMLHttpRequest();
var url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson'; /*URL*/
var queryParams = '?' + encodeURIComponent('serviceKey') + '=' + serviceKey; /*Service Key*/
queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent('20200101'); /**/
queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent('20200505'); /**/
xhr.open('GET', url + queryParams);
let itemList = [];
let itemListLength;

fetch(url + queryParams)
    .then(response => response.text())
    .then(data => new window.DOMParser().parseFromString(data, "text/xml"))
    .then(data => data.getElementsByTagName("item"))
    .then(function (items) {
            for (let i = 0; i < items.length; i++) {
                let accDefRate = items[i].getElementsByTagName("accDefRate")[0].innerHTML;
                let accExamCnt = items[i].getElementsByTagName("accExamCnt")[0].innerHTML;
                let createDt = items[i].getElementsByTagName("createDt")[0].innerHTML;
                let deathCnt = items[i].getElementsByTagName("deathCnt")[0].innerHTML;
                let seq = items[i].getElementsByTagName("seq")[0].innerHTML;
                let stateDt = items[i].getElementsByTagName("stateDt")[0].innerHTML;
                let updateDt = items[i].getElementsByTagName("updateDt")[0].innerHTML;

                let item = {
                    accDefRate,
                    accExamCnt, //총 감염자?
                    createDt,   //기준일
                    deathCnt,   //누적 사망자
                    seq,
                    stateDt,
                    updateDt    //마지막 업데이트 날짜
                }
                itemList.push(item);
            }
            itemList = itemList.reverse();
            getItemListLength()
        }
    ).catch((error) => {
    console.log(error)
});

console.log(itemList);

function getItemListLength(){
    console.log(itemList.length)
    itemListLength = itemList.length;

    //getListValue()
    printTableData()
}


acclist = [];
function getaccValue() {
    itemList.forEach(function (obj){
        acclist.push(obj.accExamCnt);
    })

    return acclist;
}

labellist = [];
function getLabelValue() {
    itemList.forEach(function (obj){
        labellist.push(obj.createDt);
    })

    return labellist;
}

function printTableData() {
    test = document.querySelector("#contents");
    for (let i = 0; i < itemListLength; i++) {
        test.innerHTML +=`
        <tr>
            <td>${itemList[i].createDt}</th>
            <td>${itemList[i].accExamCnt}</th>
            <td>${itemList[i].deathCnt}</th>
            <td>${itemList[i].updateDt}</th>
        </tr>
        `;
    }
    chartdraw();
}

function chartdraw(){
    var dead = [];
    var addCovid = [];
    var dayday = [];
    for (let i = 0; i < itemList.length; i++) {
        dayday[i] = itemList[i].stateDt;
        dead[i] = itemList[i].deathCnt;
        addCovid[i] = itemList[i].accExamCnt;
    }
    var ctx = document.getElementById("myChart").getContext("2d");
    var chart = new Chart(ctx, {
        type: "line",
        data: {
            labels: dayday,
            datasets: [
                {
                    label: "누적 사망자 수",
                    backgroundColor: "transparent",
                    borderColor: "blue",
                    data: dead,
                },
                {
                    label: "누적 확진자 수",
                    backgroundColor: "transparent",
                    borderColor: "red",
                    data: addCovid,
                },
            ],
        },
        options: {},
    });
}

