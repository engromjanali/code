const int ledp=12;
const int ldrp = A0;



void setup() {
  // put your setup code here, to run once:
  Serial.begin(9800);
  pinMode(ledp, OUTPUT);
  pinMode(ldrp, INPUT);
}

void loop() {
  int ldrStatus = analogRead(ldrp);
  Serial.println(ldrStatus);

  // put your main code here, to run repeatedly:

}
