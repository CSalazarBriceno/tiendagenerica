function nameFile(){
    var name=document.getElementById('fileUpload').files[0].name
    document.getElementById('file').innerHTML=name;
}