from tkinter import *

class MainGUI(Frame):
    #constructor
    def __init__(self,parent):
        Frame.__init__(self,parent,bg="white")
        #run a method that sets up the layout
        self.setupGUI()

    #setting up the layout of the calculator
    def setupGUI(self):
        #setup the label
        self.display = Label(self,text="",anchor=E,bg="white",height=1,width=5, font=("Arial",40))
        self.display.grid(row=0,column=0,columnspan=5,sticky=E+W+N+S)

        #setup the lpr button
        img = PhotoImage(file="images/lpr.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white",command=lambda: self.process("("))
        button.image = img
        button.grid(row=1,column=0,sticky=N+S+E+W)

        #setup the rpr button
        img = PhotoImage(file="images/rpr.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process(")"))
        button.image = img
        button.grid(row=1,column=1,sticky=N+S+E+W)

        #setup the ac button
        img = PhotoImage(file="images/clr.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("AC"))
        button.image = img
        button.grid(row=1,column=2,sticky=N+S+E+W)
        
        #setup the back button
        img = PhotoImage(file="images/bak.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("back"))
        button.image = img
        button.grid(row=1,column=3,sticky=N+S+E+W)

        #setup the pow button
        img = PhotoImage(file="images/pow.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("**"))
        button.image = img
        button.grid(row=6,column=2,sticky=N+S+E+W)
        
        #setup the modulus button
        img = PhotoImage(file="images/mod.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("%"))
        button.image = img
        button.grid(row=6,column=3,sticky=N+S+E+W)

        #setup the 7 button
        img = PhotoImage(file="images/7.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("7"))
        button.image = img
        button.grid(row=2,column=0,sticky=N+S+E+W)

        #setup the 8 button
        img = PhotoImage(file="images/8.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("8"))
        button.image = img
        button.grid(row=2,column=1,sticky=N+S+E+W)

        #setup the 9 button
        img = PhotoImage(file="images/9.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("9"))
        button.image = img
        button.grid(row=2,column=2,sticky=N+S+E+W)

        #setup the / button
        img = PhotoImage(file="images/div.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("/"))
        button.image = img
        button.grid(row=2,column=3,sticky=N+S+E+W)

        #setup the 4 button
        img = PhotoImage(file="images/4.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("4"))
        button.image = img
        button.grid(row=3,column=0,sticky=N+S+E+W)

        #setup the 5 button
        img = PhotoImage(file="images/5.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("5"))
        button.image = img
        button.grid(row=3,column=1,sticky=N+S+E+W)

        #setup the 6 button
        img = PhotoImage(file="images/6.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("6"))
        button.image = img
        button.grid(row=3,column=2,sticky=N+S+E+W)

        #setup the * button
        img = PhotoImage(file="images/mul.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("*"))
        button.image = img
        button.grid(row=3,column=3,sticky=N+S+E+W)

        #setup the 1 button
        img = PhotoImage(file="images/1.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("1"))
        button.image = img
        button.grid(row=4,column=0,sticky=N+S+E+W)

        #setup the 2 button
        img = PhotoImage(file="images/2.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("2"))
        button.image = img
        button.grid(row=4,column=1,sticky=N+S+E+W)

        #setup the 3 button
        img = PhotoImage(file="images/3.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("3"))
        button.image = img
        button.grid(row=4,column=2,sticky=N+S+E+W)

        #setup the - button
        img = PhotoImage(file="images/sub.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("-"))
        button.image = img
        button.grid(row=4,column=3,sticky=N+S+E+W)

        #setup the 0 button
        img = PhotoImage(file="images/0.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("0"))
        button.image = img
        button.grid(row=5,column=0,sticky=N+S+E+W)

        #setup the . button
        img = PhotoImage(file="images/dot.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("."))
        button.image = img
        button.grid(row=5,column=1,sticky=N+S+E+W)

        #setup the = button
        img = PhotoImage(file="images/eql-wide.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("="))
        button.image = img
        button.grid(row=6,column=1,sticky=N+S+E+W)

        #setup the + button
        img = PhotoImage(file="images/add.gif")
        button = Button(self,bg="white",image=img,borderwidth=0,highlightthickness=0,activebackground="white", command=lambda: self.process("+"))
        button.image = img
        button.grid(row=5,column=3,sticky=N+S+E+W)

        self.pack(fill=BOTH, expand=1)
        
    #process any button calls from the layout
    def process(self,buttonName):
        expr = self.display["text"]

        if expr == "ERROR":
            self.display["text"] = ""
            
        if(len(expr)) < 14:
            if(buttonName=="="):
                try:
                    result = str(eval(expr))
                    if len(result) > 14:
                        result = result[:11] + "..."
                except:
                    result = "ERROR"
                self.display["text"]=result
            elif(buttonName=="AC"):
                self.display["text"]=""
            elif(buttonName=="back"):
                self.display["text"]=self.display["text"][:-1]
            else:
                self.display["text"]+=buttonName
        elif(buttonName=="AC"):
            self.display["text"]=""
        elif(buttonName=="back"):
            self.display["text"]=self.display["text"][:-1]
        
window = Tk()
window.title("Calculator")
p = MainGUI(window)

window.mainloop()
