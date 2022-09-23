//1 create an array of employee objects
var employees = [
  { id: 22, name: "kapil", salary: 1000 },
  { id: 3, name: "ksb", salary: 7000 },
  { id: 2, name: "ok", salary: 2400 },
  { id: 4, name: "rahul", salary: 6000 },
];

// 2 function to add employee to employee array
function addEmployee(employee) {
  employees.push(employee);
  var str = "";
  for (var i = 0; i < employees.length; i++) {
    str =
      str +
      employees[i].id +
      " " +
      employees[i].name +
      " " +
      employees[i].salary +
      "  <br />";
  }
  console.log(str);
  document.getElementById("demo").innerHTML = str;
  displayEmployees();
  return employees;
}

// 3.1 function to remove employee from employees  using employee id
function removeEmployee(id) {
  // var employeeList = employees.filter(function (employee) {
  //   return employee.id !== id;
  // });
  // // employees.splice(employees.indexOf(id), 1);
  // var str = "";
  // for (var i = 0; i < employeeList.length; i++) {
  //   str =
  //     str +
  //     employees[i].id +
  //     " " +
  //     employees[i].name +
  //     " " +
  //     employees[i].salary +
  //     "  <br />";
  // }
  // employees = employeeList;
  // console.log(str);
  // document.getElementById("demo").innerHTML = str;

  // updated version
  const findIndex = employees.findIndex((employee) => employee.id === id);
  findIndex != -1 && employees.splice(findIndex, 1);
  console.log(employees);
  var str = "";
  for (var i = 0; i < employees.length; i++) {
    str =
      str +
      employees[i].id +
      " " +
      employees[i].name +
      " " +
      employees[i].salary +
      "  <br />";
  }
  console.log(str);
  document.getElementById("demo").innerHTML = str;
}

// 3.2 function to update an employee by id from employee array
function updateEmployee(id, employee) {
  e = employees.find((emp) => emp.id === employee.id);
  e.name = employee.name;
  e.salary = employee.salary;
  displayEmployees();
}

// 4 function to to get the employee object by id from employees array
function getEmployee(id) {
  employee = employees.find((emp) => emp.id === id);
  return employee;
}

//  5 display employees array
function displayEmployees() {
  var str = "";
  for (var i = 0; i < employees.length; i++) {
    str =
      str +
      employees[i].id +
      " " +
      employees[i].name +
      " " +
      employees[i].salary +
      "  <br />";
  }
  console.log(str);
  document.getElementById("demo").innerHTML = str;
}

// 6 function to display employee
function employee(id) {
  let emp = employees.find((emp) => emp.id === id);
  document.getElementById("employee").innerHTML =
    emp.id + " " + emp.name + " " + emp.salary;
}

//  7 sort employees uinsg  id, name, and salary
function sortBy(sortType) {
  if (sortType == 1) {
    // by id
    employees.sort(function (a, b) {
      return a.id - b.id;
    });
    displayEmployees();
  } else if (sortType == 2) {
    // by name
    employees.sort(function (a, b) {
      return a.name.localeCompare(b.name);
    });
    displayEmployees();
  } else if (sortType == 3) {
    // by salary
    employees.sort(function (a, b) {
      return a.salary - b.salary;
    });
    displayEmployees();
  }
}
