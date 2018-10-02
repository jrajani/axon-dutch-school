package io.blueharvest.labs.axon.command;

import io.blueharvest.labs.axon.common.command.AddCourseCommand;
import io.blueharvest.labs.axon.common.command.RegisterStudentCommand;
import io.blueharvest.labs.axon.common.event.AddCourseEvent;
import io.blueharvest.labs.axon.common.event.StudentRegisteredEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Course {

    @AggregateIdentifier
    private int id;
    private String name;
    private int totalStudents;

    public Course() {

    }

    @CommandHandler
    public void addCourse(AddCourseCommand command) {
        if(command.getId() < 0) throw new IllegalArgumentException("id < 0");
        apply(new AddCourseEvent(command.getId(), command.getName()));
    }

    @CommandHandler
    public void registerStudent(RegisterStudentCommand command) {
        if(command.getId() < 0) throw new IllegalArgumentException("id < 0");
        apply(new StudentRegisteredEvent(command.getId(), command.getTotalStudents()));
    }

    @EventHandler
    public void on(AddCourseEvent event) {
        this.id = event.getId();
        this.name = event.getName();
    }

    @EventHandler
    public void on(StudentRegisteredEvent evt) {
        this.totalStudents += evt.getTotalStudents();
    }
}
