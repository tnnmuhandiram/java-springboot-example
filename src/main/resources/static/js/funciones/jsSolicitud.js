$('#modalEliminar').on('show.bs.modal', function(event) {
	var enlace = $(event.relatedTarget);
	var elemento = $(event.relatedTarget);
	var href = $(elemento).attr('href');
	$('#modalEliminar #btnEliminar').attr('href', href);
});

$('#modalEliminar').on('hide.bs.modal	', function(event) {
	$('#modalEliminar #btnEliminar').attr('href', "#");
});