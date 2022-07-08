console.log("External JS file is being executed");

// getting the dom elements
var element = document.getElementById("some-id");
var elements = document.getElementsByClassName("some-class");

// CSS selectors
// let element = document.querySelector(".class-name");
// let elements = document.querySelectorAll(".class-name");

// accessing the HTML
var innerHTML = element.innerHTML; // outerHTML
console.log("=>" + innerHTML);

// changing the HTML itself
element.innerHTML = "<div><p>New inner HTML</p></div>";
console.log(element.innerHTML);

// getting the css properties
for (var i = 0; i < elements.length; i++) {
    console.log("Element " + i + ": " + getComputedStyle(elements[i]).color);
    console.log("Element " + i + ": " + getComputedStyle(elements[i]).textDecoration);
    // console.log("Element " + i + ": " + JSON.stringify(getComputedStyle(elements[i])));
}

// changing the css properties
for (var i = 0; i < elements.length; i++) {
    elements[i].style.color = "blue";
    if (i % 2 == 0) {
        elements[i].style = "color: red; transform: rotate(180deg)";
    }
    getComputedStyle(elements[i]).color = "blue"; // These styles are computed, and therefore the 'color' property is read-only.
}

// events
function displayDate() {
    document.getElementById("date-paragraph").innerHTML = '<h1>' + Date() + '</h1>';
}

document.getElementById("my-button").onclick = displayDate;

document.getElementById("my-button").onclick = () => {
    document.getElementById("date-paragraph").innerHTML = '<h1>' + Date() + '</h1>';
};


// common events:
// .. onchange	    An HTML element has been changed
// .. onclick	    The user clicks an HTML element
// .. onmouseover	The user moves the mouse over an HTML element
// .. onmouseout	The user moves the mouse away from an HTML element
// .. onkeydown	The user pushes a keyboard key
// .. onload	    The browser has finished loading the page



// Exercise time: let's use another event and change another property using that event.

// 0. define the function
function changeColor() {
    document.getElementById("excercise-paragraph").style.color = "red";
    // elemementForExcercise.style.color = "red"; // possible to use like this, since var was used
}

// 1. select the element w/ Javascript
var elemementForExcercise = document.getElementById("excercise-paragraph");

// 2. attach the event handler (... which will be the changeColor function)
elemementForExcercise.onmouseover = changeColor;

// ... with anonymous function
// document.getElementById("my-button").onclick = function(){
//     document.getElementById("date-paragraph").innerHTML = '<h1>' + Date() + '</h1>';
// };

// ... with arrow functions
document.getElementById("my-button").onclick = () => {
    document.getElementById("date-paragraph").innerHTML = '<h1>' + Date() + '</h1>';
};


// create html element
let element = document.createElement("div");


// appendChild(element) - adds an element as the last child of a parent
let parent = document.getElementById("id-name");
let child = document.createElement("div");
parent.appendChild(child);


// removeChild(element) - removes the child of the element
let parent = document.getElementById("id-name");
let child = document.createElement("div");
parent.removeChild(child);


// classlist api
// ... returns the classes it has, in an array-like object
document.getElementById("id-name").classList;
document.getElementById("id-name").classList.contains("class-name");
document.getElementById("id-name").classList.add("new-class-name");
document.getElementById("id-name").classList.remove("class-name");


// EXERCISE:
// 1. Create a simple HTML with a paragraph (with any text) and two buttons
// 2. When page loads the paragraph has no color (white with black text)
// 3. One button makes the text blue, the other makes it red





// SOLUTION
// <!DOCTYPE html>
// <html lang="en">
// <head>
//     <meta charset="UTF-8">
//         <title>Title</title>
//         <script>
//             function colorChangeBlue() {
//             document.getElementById("paragraph").style.color = "blue";
//         }
//             function colorChangeRed() {
//             document.getElementById("paragraph").style.color = "red";
//         }
//         </script>
// </head>
// <body>
// <p id="paragraph">Some text</p>
// <button onclick="colorChangeBlue()" id="blue">Click me</button>
// <button onclick="colorChangeRed()" id="red">Click me</button>
// </body>
// </html>
