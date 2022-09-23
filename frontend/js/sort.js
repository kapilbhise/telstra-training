// function to sort the items in the array
function sort(arrayList) {
  // sort the array
  arrayList.sort(function (a, b) {
    return a - b;
  });

  // return the array
  return arrayList;
}

console.log(sort([1, 4, 5, 9, 20, 3]));

// function to find maximum element in arrayList
function findMaxElement(arrayList) {
  // find the maximum element in the array
  for (var i = 0; i < arrayList.length; i++) {
    if (arrayList[i] > maxElement) {
      maxElement = arrayList[i];
    }
  }

  // return the maximum element in the array
  return maxElement;
}

this.onload = function () {
  // create a table
  var table = document.createElement("table");
  table.setAttribute("class", "table");
  table.setAttribute("id", "table");
  document.body.appendChild(table);
};

// looping through the array
function looping(array) {
  // loop through the array
  for (var i = 0; i < array.length; i++) {
    // loop through the array
    console.log(array[i]);
  }
}

