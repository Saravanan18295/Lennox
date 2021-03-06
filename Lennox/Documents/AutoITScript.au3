$vVariable = """C:\Users\saravanan.pazhani\eclipse-workspace\Lennox\Documents\Test1.PDF"" ""C:\Users\saravanan.pazhani\eclipse-workspace\Lennox\Documents\Test2.PDF"""
ControlFocus("Open","","Edit1")
ControlSetText("Open","","Edit1",$vVariable)
ControlClick("Open","","Button1")