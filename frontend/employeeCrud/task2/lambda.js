// create a lambda function to find  a number is prime or not
const isPrime = (n) => {
  if (n < 2) {
    return false;
  }
  for (let i = 2; i < n; i++) {
    if (n % i === 0) {
      return false;
    }
  }
  return n !== 1;
};
// console.log(isPrime(2));

// Create a Lambda function to find power (p) of a number(n)
const power = (n, p) => {
  return Math.pow(n, p);
};
// console.log(power(2, 5));

//Create a Lambda function to get last 2 digits of a number. i/p: 4578 o/p: 78
const last2Digits = (n) => n % 100;
// console.log(last2Digits(4567));

// Create a Lambda function to remove last 2 digits of a number. i/p: 2022 o/p: 20
const removeLast2Digits = (n) => Math.round(n / 100);
// console.log(removeLast2Digits(2048));

let employees = [
  { id: 22, name: "kapil", salary: 1000 },
  { id: 3, name: "ksb", salary: 7000 },
  { id: 2, name: "ok", salary: 2400 },
  { id: 4, name: "rahul", salary: 6000 },
];

const displayEmployees = () => {
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
};

// Create a Lambda function to increase employee salary by 10%
const increaseEmployeeSalary = (id) => {
  employee = employees.filter((e) => e.id == id);
  employee[0].salary = employee[0].salary + employee[0].salary / 10;
  displayEmployees();
  return employee[0];
};
// console.log(increaseEmployeeSalary(20123));

// Create a Lambda function to remove an employee by id
const removeEmployee = (id) => {
  employees = employees.filter((e) => e.id !== id);
  displayEmployees();
  return employees;
};
// console.log(removeEmployee(2));

// Create a Lambda function to update an employee name by id
const updateEmployeeName = (id, name) => {
  employees.forEach((e) => {
    if (e.id === id) {
      e.name = name;
    }
  });
  displayEmployees();
  return employees;
};

// console.log(updateEmployeeName(22, "kapil bhise"));
