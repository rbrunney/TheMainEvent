const typeOfEvent = getElementById('typeOfEvent');
const dateOfEvent = getElementById('dateOfEvent');
const locationOfEvent = getElementById('locationOfEvent');
const numberOfGuest = getElementById('numberOfGuest');
const totalCostOfEvent = getElementById('totalCostOfEvent');

function orderAP() {
    const request = new XMLHttpRequest();
    request.open("localhost:8082://");
    request.send();
    request.onload = () => {

    };
}