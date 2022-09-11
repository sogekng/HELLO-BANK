// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable();
});

function open(id){
  document.querySelector('#'+id).checked = true;
}