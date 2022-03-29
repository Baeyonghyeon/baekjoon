/* 끝 페이지 */
let endPage;
/*전체 게시물 수*/
let total;
/* 현재 페이지, 페이지당 게시물 표시수 정보 */
let currentPage = 0;
/* 코드에서는 3개식 게시물이 넘어감.*/
let currentPost = 0;
/* 보여주고싶은 뷰 수 */
let viewpageCount = 8;
/* 파싱하고 item tag까지 들어간 요소들 이것으로 지역누르면 선택 지역 필터링 할거임 */
let items;
/* 지역까지 구분완료한 리스트들 이것들로 테이블 값을 만든다.*/
let list = [];
/* 처음 대륙 초기값 */
let country = "아프리카"
/* 파싱값 */
var mal
/* 지도 그리기 데이터*/

window.addEventListener("load", function () {
    getData()
        .then(parse)
        .then(makeTable)
});

function getData() {
    let serviceKey = "hU1pT%2Bq4rSsCEbJYjtv1Gqctta4YxYeI7ZAxFth%2BmtTUu%2FyMoxj4IZRZc9ADM8DEr8PkQC7EmCJjd%2FEjSaFFUg%3D%3D\n";
    return new Promise(function (resolve, reject) {
        const xhr = new XMLHttpRequest();
        const url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19NatInfStateJson'; /*URL*/
        let queryParams = '?' + encodeURIComponent('serviceKey') + '=' + serviceKey; /*Service Key*/
        queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
        queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
        queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent('20220301'); /**/
        queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent(getToday()); /**/
        xhr.open('GET', url + queryParams);
        xhr.onreadystatechange = function () {

            if (this.readyState == 4) {
                if (this.status == 200) {
                    let msg = this.responseXML.getElementsByTagName("resultMsg")[0].innerHTML;
                    if (msg == "NORMAL SERVICE.") {
                        mal = this.responseXML;
                        resolve(this.responseXML);
                    } else {
                        reject(new Error(msg));
                    }
                } else if (this.status == 403) {
                    reject(new Error("Forbidden"));
                } else if (this.status == 404) {
                    reject(new Error("Not Found"));
                } else if (this.status == 500) {
                    reject(new Error("Internal Server Error"));
                } else {
                    reject(new Error("Unknown Error"));
                }
            }
        };

        xhr.send("");
    });
}

// 파라미터 대신 전역변수로 걸러낼것을 고른다...?
// 재사용하지말고 필터링..
function parse(xmlDoc) {
    return new Promise(function (resolve, reject) {
        items = xmlDoc.getElementsByTagName("item");
        let itemList = [];
        console.log("parse해서 넘어온 값 : " + items.length);
        console.log(items)
        for (let i = 0; i < 190; i++) { //데이터의 나라는 190개가 있다.
            let areaNm = items[i].getElementsByTagName("areaNm")[0].innerHTML;  // 대륙
            let nationNm = items[i].getElementsByTagName("nationNm")[0].innerHTML;  //한국 국가명
            let nationNmEn = items[i].getElementsByTagName("nationNmEn")[0].innerHTML; //영어 국가명
            let natDefCnt = items[i].getElementsByTagName("natDefCnt")[0].innerHTML;//누적 확진자수
            let newNatDefCnt = items[i].getElementsByTagName("natDefCnt")[0].innerHTML;// 신규 확진자
            let natDeathRate = items[i].getElementsByTagName("natDeathRate")[0].innerHTML;  //사망률




            if(areaNm == country){
                //신규확진자 계산
                newNatDefCnt -= items[i+190].getElementsByTagName("natDefCnt")[0].innerHTML;
                console.log(nationNm)
                console.log(items[i].getElementsByTagName("nationNm")[0].innerHTML)

                let item = {
                    nationNm,
                    natDefCnt,
                    newNatDefCnt,
                    natDeathRate
                };
                itemList.push(item);
            }

        }
        console.log("담아둔 아이템 리스트개수 : " + itemList.length);
        resolve(itemList);

    })
}

function handleOnChange(e) {
    country = e.value; // 선택된 데이터 가져오기
    console.log(country)     // 데이터 출력
    parse(mal)
        .then(makeTable)
}

function makeTable(itemList) {
    total = itemList.length;
    endPage = parseInt(((total + viewpageCount - 1) / viewpageCount));
    list = itemList;

    let element = document.querySelector("#contents");
    element.innerHTML = ``;

    for (let i = currentPost; i < currentPost + viewpageCount; i++) {
        element.innerHTML += `
        <tr>
            <td><a href="javascript:void(0);" id="${itemList[i].nationNm}" onclick="sendId('${itemList[i].nationNm}');return false;" return = false>${itemList[i].nationNm}</a></th>
            <td>${itemList[i].natDefCnt}</th>
            <td>${itemList[i].newNatDefCnt}</th>
            <td>${itemList[i].natDeathRate}</th>
        </tr>
        `;
    }
    makePageCount()
    getGoogleMap()
}

function sendId(id){
    let element = document.getElementById(id);
    element.addEventListener("click", (para) => {
        window.localStorage.setItem("country", id)
        let win = window.open("Covid19Nation.html", "_blank");
        win.focus()
    });
}

//yyyyMMdd 형식 출력
function getToday() {
    var date = new Date();
    var year = date.getFullYear();
    var month = ("0" + (1 + date.getMonth())).slice(-2);
    var day = ("0" + date.getDate()).slice(-2);
    return year + month + day;
}


function makePageCount() {  //페이징 페이지를 표시해준다.
    let element = document.querySelector("#page");
    element.innerHTML = `
        <span>
        ${(currentPage + 1) + "/" + endPage}
        </span>
        `;
}

function getPrevElement() {
    let btn = document.getElementById("prev");
    btn.addEventListener("click", (para) => {
        if (currentPage == 0) {
            alert("이전페이지가 없습니다.");
            return false;
        } else {
            currentPage--;
            currentPost -= viewpageCount;
            makePageCount();
            makeTable(list);
        }
    });
}

function getNextElement() {
    let btn = document.getElementById("next");
    btn.addEventListener("click", (para) => {
        if (endPage == currentPage + 1) {
            alert("다음 페이지가 없습니다.");
            return false;
        } else {
            currentPage++;
            currentPost += viewpageCount;
            makePageCount();
            makeTable(list);
        }

    });
}

function getGoogleMap() {
    google.charts.load('current', {
        'packages': ['geochart'],
    });
    google.charts.setOnLoadCallback(drawRegionsMap);

    function drawRegionsMap() {
        var data = google.visualization.arrayToDataTable([
            ['Country', 'Popularity'],
            ['Germany', 200],
            ['United States', 300],
            ['Brazil', 400],
            ['Canada', 500],
            ['France', 600],
            ['RU', 700]
        ]);

        var options = {};
        var chart = new google.visualization.GeoChart(document.getElementById('chart_div'));
        chart.draw(data, options);
    }
}

window.addEventListener("load", getPrevElement);
window.addEventListener("load", getNextElement);

