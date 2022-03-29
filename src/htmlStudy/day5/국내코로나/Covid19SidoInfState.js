/* 끝 페이지 */
let endPage;
/*전체 게시물 수*/
let total;
/* 현재 페이지, 페이지당 게시물 표시수 정보 */
let currentPage = 0;
/* 코드에서는 3개식 게시물이 넘어감.*/
let currentPost = 0;
/* 보여주고싶은 페이지 수 */
let viewpageCount = 6;
/* 파싱하고 item tag까지 들어간 요소들 이것으로 지역누르면 선택 지역 필터링 할거임 */
let items ;
/* 지역까지 구분완료한 리스트들 이것들로 테이블 값을 만든다.*/
let list = [];

window.addEventListener("load", function () {
    getData()
        .then(parse)
        .then(makeTable)
});

function getData() {
    let serviceKey = "hU1pT%2Bq4rSsCEbJYjtv1Gqctta4YxYeI7ZAxFth%2BmtTUu%2FyMoxj4IZRZc9ADM8DEr8PkQC7EmCJjd%2FEjSaFFUg%3D%3D";
    return new Promise(function (resolve, reject) {
        const xhr = new XMLHttpRequest();
        const url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson'; /*URL*/
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

function parse(xmlDoc) {
    return new Promise(function (resolve, reject) {
        items = xmlDoc.getElementsByTagName("item");
        let itemList = [];
        console.log("parse해서 넘어온 값 : "+items.length);
        console.log(items)
        for (let i = 0; i < items.length; i++) {
            let seq = items[i].getElementsByTagName("seq")[0].innerHTML;
            let gubun = items[i].getElementsByTagName("gubun")[0].innerHTML;
            let defCnt = items[i].getElementsByTagName("defCnt")[0].innerHTML;
            let incDec = items[i].getElementsByTagName("incDec")[0].innerHTML;

            if (gubun == "합계") {
                break
            }

            let item = {
                seq,
                gubun,
                defCnt,
                incDec
            };
            itemList.push(item);
        }
        console.log("담아둔 아이템 리스트개수 : "+itemList.length);
        resolve(itemList);
    })
}

//서울만 뽑는다고 가정할때 parse르

function makeTable(itemList) {
    total = itemList.length;
    console.log(total);
    endPage = parseInt(((total + viewpageCount-1) / viewpageCount));
    console.log(endPage)
    list = itemList;

    let element = document.querySelector("#contents");
    element.innerHTML = ``;

    //
    for (let i = currentPost; i < currentPost + viewpageCount; i++) {
        element.innerHTML += `
        <tr>    
            <td><a href="javascript:void(0);" id="${itemList[i].gubun}" onclick="sendId('${itemList[i].gubun}');return false;" return = false>${itemList[i].gubun}</a></th>
            <td>${itemList[i].defCnt}</th>
            <td>${itemList[i].incDec}</th>
        </tr>
        `;
    }

    makePageCount()
    window.addEventListener("load", sendId);
}

function sendId(id){
    let element = document.getElementById(id);
    element.addEventListener("click", (para) => {
        window.localStorage.setItem("sido", id)
        let win = window.open("Covid19Sido.html", "_blank");
        win.focus()
    });
}

//yyyyMMdd 형식 출력
function getToday(){
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
        ${(currentPage+1)+"/"+endPage}
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
        if (endPage == currentPage+1) {
            alert("다음 페이지가 없습니다.");
            return false;
        }else{
            currentPage++;
            currentPost += viewpageCount;
            makePageCount();
            makeTable(list);
        }

    });
}

window.addEventListener("load", getPrevElement);
window.addEventListener("load", getNextElement);

