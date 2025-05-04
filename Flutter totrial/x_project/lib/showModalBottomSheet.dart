class _xxxState extends State<xxx> {
    bool visibleCurrent = false;
  bool visibleNew = false;
  bool visibleConfirm = false;
  @override
  Widget build(BuildContext context) {
    return  Container(
        color: Colors.grey,
        height: double.infinity,
        width: double.infinity,
        child: ListView(
          children: [
            getItem(label: "Security", icon: Icons.security, ontap: (){
              return showModalBottomSheet(
                isScrollControlled: true,// otherwise we get  abnormal size.
                context: context, 
                builder: (BuildContext content){
                  return StatefulBuilder(builder: (BuildContext context, StateSetter setModalState){
                    return Container(
                    decoration: BoxDecoration(
                      borderRadius: BorderRadius.only(topLeft: Radius.circular(20), topRight: Radius.circular(20)),
                    // color: Colors.green,
                    ),
                    height: 600,
                    width: double.infinity,
                    child: Column(
                      children: [
                        SizedBox(
                          height: 20,
                        ),
                        Container(
                          padding: EdgeInsets.symmetric(horizontal: 10),
                          decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(10),
                            color: Colors.amber,
                            border: Border(bottom: BorderSide(color: Colors.black))
                          ),
                          margin: EdgeInsets.all(10),
                          child: TextFormField(
                            decoration: InputDecoration(
                              label: Text("Confirm Password"),
                              border: InputBorder.none,
                              suffixIcon:
                              IconButton(
                                onPressed: (){ 
                                  setModalState(() { // the setModalState work in "showModalBottomSheet"
                                    setState(() { // the setstate work in main page
                                      
                                    });
                                    debugPrint(visibleConfirm.toString()); 
                                    visibleConfirm = !visibleConfirm;
                                  });
                                }, 
                                icon: visibleConfirm? Icon(Icons.visibility) : Icon(Icons.visibility_off),
                              ),
                            ),
                          ),
                        ),
                        SizedBox(
                          height: 20,
                        ),
                        Material(
                          
                          child: getButton(),
                        )
                      ],
                    ),
                  );
                  });
              });
            },
            ),
          ],
        ),
      );
  }
}