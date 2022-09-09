function create_tbody(table_id) {
    var table = document.getElementById(table_id);
    var tbody = document.createElement("tbody");
    var tr = document.createElement("tr");
    var td1 = document.createElement("td");
    var td2 = document.createElement("td");
    var td3 = document.createElement("td");
    var td4 = document.createElement("td");
    var td5 = document.createElement("td");
    var text1 = document.createTextNode(1);
    var text2 = document.createTextNode(2);
    var text3 = document.createTextNode(3);
    var text4 = document.createTextNode(4);
    var text5 = document.createTextNode(5);

    td1.appendChild(text1);
    td2.appendChild(text2);
    td3.appendChild(text3);
    td4.appendChild(text4);
    td5.appendChild(text5);
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tr.appendChild(td5);
    tbody.appendChild(tr);
    table.appendChild(tbody);


}