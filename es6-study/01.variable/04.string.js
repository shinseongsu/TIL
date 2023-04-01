let string = "안녕하세요";
string = "안녕!";

console.log(string);

string = '"안녕!"';

string = "안녕\n엘리야!\t\t내 이름은\\\u09AC";
console.log(string);

let id = "엘리";
let greetings = "'안녕!, " + id + "\n즐거운 하루 보내요!'";
console.log(greetings);

greetings = `안녕, ${id}
즐거운 하루 보내세요!'`;
console.log(greetings);
