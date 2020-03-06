console.log("ABCD");
class Animal {
    move(distanceInMeters = 0) {
        console.log(`Animal moved ${distanceInMeters}m.`);
    }
}
class Dog extends Animal {
    bark() {
        console.log('Woof! Woof!');
    }
}
const dog = new Dog();
dog.bark();
// dog.move("a"); --> 'compiler' error
dog.move(10);
dog.bark();
