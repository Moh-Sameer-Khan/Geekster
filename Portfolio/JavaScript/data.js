const ele = document.getElementById("my-form");
ele.addEventListener("submit",(e)=>{
    e.preventDefault();
    confirm("Message sent successfully");
})