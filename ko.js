// const  fs = require("fs")
// var robot = {
//     name: 'Robot',
//     height: 1.6,
//     run: function () {
//         console.log(this.name + ' is running...');
//     }
// };
// robot.run()
// console.log(robot.constructor)
// // console.log(fs)
// module.exports={
//     r:robot
// }
// console.log(module)
// console.log(this)
const _ = require('underscore')
class Example {
    static test() {
        console.log("testing !!")
    }


    static a = 2;
}

Example.test()
console.log(Example.a)
var Student = {
    name: 'Robot',
    height: 1.2,
    run: function () {
        console.log(this.name + ' is running...');
    }
};

function createStudent(name) {
    // 基于Student原型创建一个新对象:
    var s = Object.create(Student);
    // 初始化新对象:
    s.name = name;
    return s;
}



var obj = {
    name: 'bob',
    school: 'No.1 middle school',
    address: 'xueyuan road'
};
var upper = _.map(obj, function (value, key) {
    return value;
});
for (const upperKey of upper) {
    console.log(upperKey)
}

//
//
// var xiaoming = createStudent('小明');
// xiaoming.run(); // 小明 is running...
// console.log((xiaoming.__proto__ === Student)); // true
// console.log(xiaoming.height);