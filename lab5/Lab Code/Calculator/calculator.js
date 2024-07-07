function calculateRemainder() {
    const dividend = document.getElementById("dividend");
    const divisor = document.getElementById("divisor");
    let x = dividend.value;
    let y= divisor.value;
    let val = x%y;
    document.getElementById("result-message").innerHTML ="The remainder of " + x + " and " + y + " is " + val;
    //disable buttons
    dividend.style.backgroundColor ="red";
    divisor.style.backgroundColor ="red";
    dividend.disabled =true;
    divisor.disabled = true;
}

function reset() {
    const dividend = document.getElementById("dividend");
    const divisor = document.getElementById("divisor");
    dividend.style.backgroundColor ="white";
    divisor.style.backgroundColor ="white";
    dividend.disabled =false;
    divisor.disabled = false;
    dividend.value = "";
    divisor.value = "";
    document.getElementById("result-message").innerHTML = "";
}

const calculatButton = document.getElementById('calculate-button');
const resetButton = document.getElementById('reset-button');

calculatButton.addEventListener("click", calculateRemainder);
resetButton.addEventListener("click", reset);

