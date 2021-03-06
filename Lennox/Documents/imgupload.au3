$vVariable = """C:\Users\saravanan.pazhani\eclipse-workspace\Lennox\Documents\Image\Testimg1.png"" ""C:\Users\saravanan.pazhani\eclipse-workspace\Lennox\Documents\Image\Testimg2.png"""
ControlFocus("Open","","Edit1")
ControlSetText("Open","","Edit1",$vVariable)
ControlClick("Open","","Button1")