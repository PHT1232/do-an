window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('datatablesSimple');
    const datatablesStudent = document.getElementById('datatablesStudent');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }if (datatablesStudent) {
        new simpleDatatables.DataTable(datatablesStudent);
    }
});
