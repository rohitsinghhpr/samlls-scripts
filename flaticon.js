/*
go to the icon pack page and run this script and this will give an array of links of img and img size can be change.
*/

let li = document.querySelectorAll(".search-result li");
let links = new Array();
li.forEach((ele)=>{
    if(ele.querySelector(".icon--holder img")){
        console.log(ele.querySelector(".icon--holder img"));
        links.push(ele.querySelector(".icon--holder img").getAttribute("src"));
    }
});
console.log(links);
