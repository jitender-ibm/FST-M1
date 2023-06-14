class Car:
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " has started moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped moving")

car1 = Car("Skoda", "Kushaq", "2021", "Manual", "Silver")
car2 = Car("volkswagen", "Polo", "2015", "Manual", "Red")
car3 = Car("Audi", "RS3", "2022", "Automatic", "Blue")

car1.accelerate()
car1.stop()

car2.accelerate()
car2.stop()

car3.accelerate()
car3.stop()