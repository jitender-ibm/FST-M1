from selenium import webdriver
from selenium.webdriver import ActionChains, Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    driver.get("https://www.training-support.net/selenium/input-events")

    print("Page title is: ", driver.title)

    actions = ActionChains(driver)

    actions.send_keys("A") # Press the key of your first names initial
    actions.key_down(Keys.CONTROL) # Press and hold the CONTROL key
    actions.send_keys("a") # Press "a"
    actions.send_keys("c") # Press "c"
    actions.key_up(Keys.CONTROL) # Relase the CONTROL key
    actions.perform() # Perform the action chain