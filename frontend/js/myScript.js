function myFunction2() {
  var i = 10;
  var i = 20;

  //let j;
  let j = 10;

  {
    const x = 10;
    let y = 20;
    document.getElementById("demo").innerHTML = "Paragraph changed: i=" + i;
  }

  document.getElementById("demo").innerHTML =
    "Paragraph changed:" + x + ":" + y;
}
