if __name__ == '__main__':
    datei_name = input("Dateiname: ")
    file = open(datei_name + ".py", "w")
    img_src = "D:/Workspace/TryPy/grass_1.png"
    img_screen = "\t"
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
            putting = str(app_name) + ".addImage(" + output + ", \"\",\"" + img_src + "\"," + str(crow) + "," + str(ccolum) + ")\n\t"
            img_screen = img_screen + putting
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
    file.write(img_screen)
    file.write("\n\t")
    file.write(str(end))
