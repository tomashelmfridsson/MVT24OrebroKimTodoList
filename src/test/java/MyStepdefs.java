import ToDoList.Todolist.todo.TodoList;
import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import static org.junit.Assert.*;

public class MyStepdefs {
    private TodoList todoList;
    private static int count = 1;

    @Before
    public void setUp() {
        System.out.println("Initierar test: " + count);
        count++;

    }

    @Given("jag har en todolista")
    public void jagHarEnTodolista() {
        todoList = new TodoList();
        System.out.println("Kollar så to do list existerar");
        assertNotNull(todoList);
    }

    @When("användaren lägger till en uppgift med beskrivningen {string}")
    public void anvandarenLaggerTillEnUppgiftMedBeskrivningen(String description) {
        System.out.println("lägger till uppgift med beskrivningen: " + description);
        todoList.addTask(description);

    }

    @Then("uppgiften ska ha beskrivningen {string}")
    public void uppgiftenSkaHaBeskrivningen(String expected) {
        System.out.println("kollar så att uppgiften har beskrivningen: " + expected);
        String actual = todoList.getList();
        System.out.println(actual);
        assertEquals(expected, actual);

    }

    @When("användaren markerar uppgiften {int} som klar")
    public void anvandarenMarkerarUppgiftenSomKlar(int index) {
        System.out.println("Markerar uppgiften som klar (Städa huset)");
        todoList.completeTask(index);
    }

    @Then("ska uppgiften vara markerad som klar")
    public void skaUppgiftenVaraMarkeradSomKlar() {
        System.out.println("kontrollerar så Städa huset är klar");
        assertTrue(todoList.isTaskFinished(0));
    }

    @Then("Uppgifter i todolista ska stämma {int}")
    public void uppgifterITodolistaSkaStamma(int expected) {
        int actual = todoList.getNbrOfTasks();
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Then("antalet genomförda uppgifter ska vara {int}")
    public void antaletGenomfordaUpgifterSkaVara(int expected) {
        int actual = todoList.getFinishedTasks();
        System.out.println(actual);
        assertEquals(expected, actual);
        System.out.println(todoList.getList());
    }

    @And("listan ska var klar")
    public void listanSkaVarKlar() {
        assertTrue(todoList.isListFinished());
        System.out.println(todoList.isListFinished());
    }

    @And("listan ska inte vara klar")
    public void listanSkaInteVaraKlar() {
        assertFalse(todoList.isListFinished());
    }

    @Then("antalet uppgifter ska vara {int}")
    public void antaletUppgifterSkaVara(int expected) {
        int actual = todoList.getNbrOfTasks();
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @When("användaren tar bort den uppgiften: {int}")
    public void anvandarenTarBortDenUppgiften(int index) {
        todoList.deleteTask(index);
    }


    @When("filtrera uppgifter baserat på status")
    public void filtreraUppgifterBaseratPaStatus() {
        todoList.getStatus();
    }

    @Then("kontrollera klar {int} inte klar {int}")
    public void kontrolleraKlarInteKlar(int exFinish, int exNotFinish) {
        assertEquals(todoList.getStatus(), "Färdiga uppgifter: "+exFinish+"\nÅterstående uppgifter: "+exNotFinish);
    }

    @Then("ändra ordningen på uppgiften")
    public void andraOrdningenPaUppgiftena() {
        System.out.println(todoList.getList());
        todoList.changeTaskOrder();
        System.out.println(todoList.getList());
    }

    @When("användaren avmarkerar uppgiften {int} som klar")
    public void anvandarenAvmarkerarUppgiftenSomKlar(int index) {
        todoList.deCompleteTask(index);
    }

    @After
    public void tearDown() {
        System.out.println("Test klart!");
    }



}
