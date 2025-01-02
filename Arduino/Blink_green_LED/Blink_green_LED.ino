

const int greenLedPin = 11;

const int greenTime = 5000;  // Green light duration

void setup() {
  pinMode(greenLedPin, OUTPUT);
}

void loop() {

  // Green light
  digitalWrite(greenLedPin, HIGH);
  delay(greenTime);
  digitalWrite(greenLedPin, LOW);
  delay(greenTime);
}
