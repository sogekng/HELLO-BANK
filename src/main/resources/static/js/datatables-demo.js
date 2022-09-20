// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable({
    lengthMenu: [
      [2, 4, 10, -1],
      [2, 4, 10, 'Todos']
    ],
  });
});