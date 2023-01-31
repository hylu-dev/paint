# Paint

_JavaFX based drawing program_

This project is a rudimentary drawing software inspired by Microsoft Paint. This was created for a computer science project at the University of Toronto Mississauga.

The compiled project is accessible at https://github.com/hylu-dev/paint/blob/main/paint.jar. A demo of the project can be viewed at https://www.hylu.dev/projects.html#section5.

---

## Sheridan PGDAP Reviewer Considerations

### Involvement

This is a team project consisting of me and three other members. My role in the project was programming a number of tools, UI design, and some architecture contributions. I've included this project to demonstrate proficiency in OOP using the Java language.

As this codebase has multiple contributors, there will be function comments indicating the work that I've done as well as the below highlights pointing to code I've written (unless otherwise stated).

### Code Highlights

The project was created using the Eclipse IDE. All scripts are found within src/paint/ with the below and commented sections relevant for review.

- **paint/Commands/**
  - Utilizes the **command pattern** to generalize all updates to the canvas or drawing settings as commands
  - **ToolErase.java**
  - **Line.java**
  - **Point.java**
  - **ToolTriangle.java**
  - **DrawWeight.java**
  - **DrawColor.java**

- **paint/Panels/**
  - Subcomponents that make up the program view
  - **UndoPanel.java**
    - With the command pattern, all types of canvas updates can be added to a stack of commands and removed when needed
  - **ColorPanel.java**
    - Colour picking window
  - **FillPanel.java**
  - **ResizeableCanvas.java**
  - **ShapePropertyPanel.java**
  - **PaintPanel.java** (Me and other contributers**)
    - Contains the drawing canvas and implements Observer pattern to update the canvas when the model (extends Observable) is updated

- **paint/Tools/**
  - Utilizes **strategy pattern** to create tools with the use of the commands. The purpose here is to have reuseability of the commands for tools. For example, both the ReadSquare and ReadRectangle use the ToolRectangle command to draw their shapes but having the ReadSquare strategy constrain aspect ratio
  - **ReadInterface.java** (Created by teammate**)
    - _In my opinion, this should have really been named **ToolStrategy** as we are implementing the strategy pattern but the current naming convention was a group decision_
    - This interface is for all drawing tools to take mouse inputs and send the required commands to the canvas to draw
  - **ReadPolyLine.java** 
    - _In following, I believe **PolyLineStrategy** would be a clearer name_
  - **ReadSquiggles.java**
  - **ReadErase.java**

- **paint/PaintModel.java** (Me and other contributers**)
  - Manages all commands made to the program
  - Some function overloading can be seen when adding/removing commands
- **paint/Paint.java** (Me and other contributers**)
  - Launches the program 
- **paint/View.java** (Me and other contributers**)
  - Displays all the visual components (paint/panels/
