
import 'package:flutter/material.dart';

class BazerEntry extends StatefulWidget {
  const BazerEntry({super.key});

  @override
  State<BazerEntry> createState() => _BazerEntryState();
}

class _BazerEntryState extends State<BazerEntry> {

  String dropDownValue = "Select Person";
  List <DropdownMenuItem> list = [
    DropdownMenuItem(
      value: "Select Person", 
      child: Text("Select Person"),
    ),
    DropdownMenuItem(
      value: "nazmul", 
      child: Text("nazmul"),
    ),
    DropdownMenuItem(
      value: "farhan", 
      child: Text("farhan"),
    ),
    DropdownMenuItem(
      value: "kapil", 
      child: Text("kapil"),
    ),
    DropdownMenuItem(
      value: "adil", 
      child: Text("adil"),
    ),
    DropdownMenuItem(
      value: 'raihan', 
      child: Text("raihan"),
    ),
    DropdownMenuItem(
      value: "al amin", 
      child: Text("al amin"),
    ),
    DropdownMenuItem(
      value: "saydur", 
      child: Text("saydur"),
    ),
    DropdownMenuItem(
      value: "sabbir", 
      child: Text("sabbir"),
    ),
    DropdownMenuItem(
      value: "saidul", 
      child: Text("saidul"),
    ),
    DropdownMenuItem(
      value: "siam", 
      child: Text("siam"),
    ),
  ];
  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.amber,
      child: SingleChildScrollView(
        scrollDirection: Axis.vertical,
        child: Column(
          children: [
            DropdownButton(

              value: dropDownValue,
              items: list, 
              onChanged: (val){
                setState(() {
                  dropDownValue = val;
                });
              },
              underline: Container(height: 2, color: Colors.red,),
              icon:Icon(Icons.menu),

            ),
          ],
        ),
      ),
    );
  }
}

// 2. --------------------------------------------with search option-------------------------------------------------
// always add 5.0.6


import 'package:flutter/material.dart';
import 'package:dropdown_search/dropdown_search.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: 'Dropdown Disable Item',
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final List<String> items = ["Romjan", "Siam", "Sayed", "Saydul"];
  final Set<String> disabledItems = {"Saydul"};
  final GlobalKey<DropdownSearchState<String>> dropdownKey =
      GlobalKey<DropdownSearchState<String>>();

  String? selectedItem = "Romjan";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Dropdown with Disabled Items")),
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: DropdownSearch<String>(
          key: dropdownKey, // Needed for reset
          items: items,
          selectedItem: selectedItem,
          dropdownDecoratorProps: const DropDownDecoratorProps(
            dropdownSearchDecoration: InputDecoration(
              labelText: "Select Member",
              border: OutlineInputBorder(),
            ),
          ),
          popupProps: PopupProps.menu(
            showSearchBox: true,

            // Disable specific item visually and functionally
            itemBuilder: (context, item, isSelected) {
              bool isDisabled = disabledItems.contains(item);
              return IgnorePointer(
                ignoring: isDisabled,
                child: ListTile(
                  title: Text(
                    item,
                    style: TextStyle(
                      color: isDisabled ? Colors.grey : Colors.black,
                    ),
                  ),
                ),
              );
            },
          ),
          onChanged: (value) {
            if (value != null && disabledItems.contains(value)) {
              // Reset visually and logically
              dropdownKey.currentState?.clear(); // clears the selection
              debugPrint("Selected disable: $selectedItem");

              ScaffoldMessenger.of(context).showSnackBar(
                const SnackBar(content: Text("This item is disabled.")),
              );
            } else {
              setState(() {
                selectedItem = value;
              });
              debugPrint("Selected enable: $value");
            }
          },
        ),
      ),
    );
  }
}
