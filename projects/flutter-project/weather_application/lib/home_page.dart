import 'package:dropdown_search/dropdown_search.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:weather_application/controller/home_controller.dart';
import 'package:weather_application/core/util/widgets/bottom_rounded_button.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final dropdownKey1 = GlobalKey<DropdownSearchState>();
  final dropdownKey2 = GlobalKey<DropdownSearchState>();
  // String selectedItem = "";



  @override
  Widget build(BuildContext context) {
    CHome cHome = Provider.of<CHome>(context, listen: false);
    return Scaffold(
      resizeToAvoidBottomInset: true,
      backgroundColor: Colors.red.shade50,
      appBar: AppBar(
        backgroundColor: Colors.black,
        foregroundColor: Colors.white,
        title: Text("Weather Application"),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text(
              "Welcome back!",
              style: TextStyle(
                color: Colors.red,
                fontSize: 24,
                fontWeight: FontWeight.w600,
              ),
            ),
          ),
      
          Padding(
            padding: EdgeInsets.all(10),
            child: Column(
              spacing: 10,
              children: [
                getDropDownSearch(
                  label: "Country",
                  hintText: "Select a Country",
                  key: dropdownKey1,
                  list: cHome.countryList,
                  disableList: cHome.disabledCountryList,
                ),
                getDropDownSearch(
                  label: "Distic",
                  hintText: "Select a Distic",
                  key: dropdownKey2,
                  list: cHome.disticsList,
                  disableList: cHome.disabledDisticList,
                ),
              ],
            ),
          ),
                Spacer(),
                getBottomRoundedButton(label: 'Check', ontap: () {  
                  var selectedCountry = dropdownKey1.currentState?.getSelectedItem;
                  var selectedDistic  = dropdownKey2.currentState?.getSelectedItem;
                  if(selectedDistic != null && selectedCountry != null){
                    cHome.getWatherData(selectedDistic, selectedCountry);
                  }
                  else{
                    ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text("Please Field All Required Field!")));
                  }
                }),
        ],
      ),
    );
  }

  Widget getDropDownSearch({
    required String label,
    required String hintText,
    required var key,
    required List<String> list,
    required List<String> disableList,
  }) {
    return DropdownSearch<String>(
      enabled: true,
      key: key, // Needed for reset
      // asyncItems: (String filter) => _getAllMemberData(),
      items: (filter, y) async {
        await Future.delayed(Duration(milliseconds: 400));
        return list;
      },
      decoratorProps: DropDownDecoratorProps(
        decoration: InputDecoration(
          labelText: label,
          hintText: "$hintText",
          border: OutlineInputBorder(),
        ),
      ),

      dropdownBuilder: (context, selectedItem) {
        return Text(selectedItem ?? "");
      },

      popupProps: PopupProps.menu(
        showSearchBox: true,

        // title: Text("sdf"),
        disabledItemFn: (item) {
          return disableList.contains(item);
        },

        // Disable specific item visually and functionally
        showSelectedItems: true,
        itemBuilder: (context, item, isDisabled, isSelected) {
          //to check isSelected required "showSelectedItems == true"

          return ListTile(
            title: Text(
              item,
              style: TextStyle(
                color: isDisabled ? Colors.grey : Colors.black,
                fontWeight: isSelected ? FontWeight.bold : FontWeight.normal,
              ),
            ),
          );
        },
      ),
      // always use this function it's tested
      // otherwise we get error because there are few bug here
      onChanged: (value) {

      },
    );
    
  }
}
