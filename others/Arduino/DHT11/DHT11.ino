#include <dht11.h>
int  output_pin = 4;

dht11 DHT11;

void  setup()
{
  Serial.begin(9600);
  pinMode(output_pin, INPUT);
}

void loop()
{
  Serial.println();

  int chk = DHT11.read(output_pin);

  Serial.print("Humidity (%): ");
  Serial.println((float)DHT11.humidity, 2);

  Serial.print("Temperature  (C): ");
  Serial.println((float)DHT11.temperature, 2);

  delay(2000);
// Use analogWrite(pin, value) on PWM-enabled pins for variable output (e.g., LED brightness, motor speed).
}