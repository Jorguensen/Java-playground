var beatings = document.getElementById('beatings')
var beatings_button = document.getElementById('beatings_button')

beatings_button.addEventListener('click', event => {
    answer = parseInt(beatings.value)
    localStorage.setItem("answer", answer);
}, true)

//Creation of buttons and respective functions
var button1 = document.createElement('button')
var button2 = document.createElement('button')
var button3 = document.createElement('button')

var answerDiv = document.getElementById('buttons')

var text1 = document.createTextNode("Sandrita's beatings > Buddy's beatings")
var text2 = document.createTextNode("Sandrita's beatings == Buddy's beatings")
var text3 = document.createTextNode("Sandrita's beatings < Buddy's beatings")

answerDiv.appendChild(button1)
answerDiv.appendChild(button2)
answerDiv.appendChild(button3)

button1.appendChild(text1)
button2.appendChild(text2)
button3.appendChild(text3)

button1.addEventListener('click', event => {
    if (parseInt(localStorage.getItem("answer")) > 5) {
        window.location = "/array"
    } else {
        window.location = "/wrong"
    }
})

button2.addEventListener('click', event => {
    if (parseInt(localStorage.getItem("answer")) === 5) {
        window.location = "/array"
    } else {
        window.location = "/wrong"
    }
})

button3.addEventListener('click', event => {
    if (parseInt(localStorage.getItem("answer")) < 5) {
        window.location = "/array"
    } else {
        window.location = "/wrong"
    }
})




