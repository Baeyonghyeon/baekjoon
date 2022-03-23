function buildCalendar() {
    var today = new Date();
    //현재 달
    lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0) + ''
    var jbSplit = lastDate.split(" ");
    curentMonth = jbSplit.at(1);
    lastDate = jbSplit.at(2);
}

function getDate() {
    buildCalendar()
    test = document.querySelector("#main");
    for (let i = 1; i <= lastDate; i++) {
        test.innerHTML += `
        <div id="leftContainer">
        <span>"${i + "일"}"</span>
        </div>
        <div id="rightContainer">
        <button type="submit" id="${"addBtn_" + i}">추가</button>
        <input type="text" id="${"addtext_" + i}"><br>
        <p>content</p>
        </div>
        `;
    }
}

function getMonth() {
    test = document.querySelector("#container");
    test.innerHTML += `<div id = "con">"${curentMonth + "달 TODO List"}"</div>`;
}

function getButtonElement(){
    for(let i=1; i<= lastDate; i++) {
        let btn = document.getElementById("addBtn_" + i);
        btn.addEventListener("click", (para) => {
            console.log("addtext_"+i);
        });
    }
}

function getName(){

}

window.addEventListener("load", getDate)
window.addEventListener("load", getMonth)
window.addEventListener("load", getButtonElement)
