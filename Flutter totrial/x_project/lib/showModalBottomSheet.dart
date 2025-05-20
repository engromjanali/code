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
                      padding: EdgeInsets.only(
                        bottom: MediaQuery.of(context).viewInsets.bottom,// by this padding we are fixing the keyboard ovarlapping, when keyboard open it return keyboard size. it's will be valid for snackber, etc also
                      ),
                    decoration: BoxDecoration(
                      borderRadius: BorderRadius.only(topLeft: Radius.circular(20), topRight: Radius.circular(20)),
                    // color: Colors.green,
                    ),
                    height: 600,//if we use here we get fixed height otherwise we get taken height by child
                    width: double.infinity,
                    child: SingleChildScrollView(// we always use it must
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
                                  // in buttomsheet for any kind of operations like keyboard open/close, resize, the buttomsheet will be rebuild mind it.
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
                    )
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