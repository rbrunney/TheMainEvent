const targetBox = document.getElementById("box3");
const btn = document.getElementById("changePassword");

function changeVisibility () {
    if(targetBox.style.display === "none"){
        targetBox.style.display = 'block';
    }else{
        targetBox.style.display = 'none'
    }
};