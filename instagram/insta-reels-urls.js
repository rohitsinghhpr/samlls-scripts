// script to extract url from reels.
// once all url done.
// console.log(printed);
const printed = new Set();
window.addEventListener("scroll", function () {
    document.querySelectorAll("div.x1ty9z65 a._a6hd").forEach(link => {
        const href = link.getAttribute("href");
        if (!printed.has(href)) {
            printed.add(href);
            console.log(href);
        }
    });
});
