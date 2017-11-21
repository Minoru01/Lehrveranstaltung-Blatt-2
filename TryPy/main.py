if __name__ == '__main__':
    datei_name = input("Dateiname: ")
    file = open(datei_name + ".py", "w")
    text_label_color = ""
    text_label = "\t"
    row = input("Zeilen: ")
    colum = input("Spalten: ")
    app_name = input("Name der GUI Instanz: ")
    print("Raster: ", row, "*", colum)
    ccolum = 0
    coloring = True
    while ccolum < int(colum):
        crow = 0
        while crow < int(row):
            output = "\"" + str(crow) + "x" + str(ccolum) + "\""
            putting = str(app_name) + ".addLabel(" + output + ",\"\" ," + str(crow) + "," + str(ccolum) + ")\n\t"

            if coloring:
                text_label_color = text_label_color + str(app_name) + ".setLabelBg(" + output + ", \"white\")\n\t"
                coloring = False
            else:
                text_label_color = text_label_color + str(app_name) + ".setLabelBg(" + output + ", \"black\")\n\t"
                coloring = True

            text_label = text_label + putting
            int(crow)
            int(ccolum)
            crow = crow + 1
        ccolum = ccolum + 1
        coloring = not coloring

    header = 'from appJar import gui\n' + \
             'if __name__ == \'__main__\': \n' + \
             '\t' + app_name + ' = gui(\"Hello World","500x500\")\n' + \
             '\t' + app_name + '.setSticky("news")\n' + \
             '\t' + app_name + '.setExpand("both")\n'

    end = "\t" + app_name + ".go()"

    file.write(str(header))
    file.write(text_label)
    file.write("\n\t")
    file.write(text_label_color)
    file.write("\n")
    file.write(str(end))
