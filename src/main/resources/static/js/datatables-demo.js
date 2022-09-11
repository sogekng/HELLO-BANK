// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable();
});


function open(id){
  document.getElementById(id).style.display = "block";
}

function close(id){
  document.getElementById(id).style.display = "none";
}