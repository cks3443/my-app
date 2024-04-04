package com.example.application.views.paymentmanager;

import com.example.application.data.SamplePerson;
import com.example.application.services.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("PaymentManager")
@Route(value = "my-view", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class PaymentManagerView extends Composite<VerticalLayout> {

    public PaymentManagerView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        TextField textField = new TextField();
        EmailField emailField = new EmailField();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        DatePicker datePicker = new DatePicker();
        DatePicker datePicker2 = new DatePicker();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        MultiSelectComboBox multiSelectComboBox = new MultiSelectComboBox();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        H6 h6 = new H6();
        Button buttonPrimary = new Button();
        HorizontalLayout layoutRow5 = new HorizontalLayout();
        Hr hr = new Hr();
        HorizontalLayout layoutRow6 = new HorizontalLayout();
        H3 h3 = new H3();
        HorizontalLayout layoutRow7 = new HorizontalLayout();
        Grid multiSelectGrid = new Grid(SamplePerson.class);
        Hr hr2 = new Hr();
        getContent().setWidth("100%");
        getContent().setHeight("min-content");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        textField.setLabel("이름");
        textField.setWidth("min-content");
        emailField.setLabel("Email");
        emailField.setWidth("min-content");
        layoutRow2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.setHeight("min-content");
        datePicker.setLabel("결제일 (시작일)");
        datePicker.setWidth("min-content");
        datePicker2.setLabel("~ 결제일 (종료일)");
        datePicker2.setWidth("min-content");
        layoutRow3.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.setHeight("min-content");
        multiSelectComboBox.setLabel("채널 선택");
        multiSelectComboBox.setWidth("min-content");
        setMultiSelectComboBoxSampleData(multiSelectComboBox);
        layoutRow4.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow4.setWidth("100%");
        layoutRow4.setHeight("min-content");
        h6.setText("★ 채널 미선택 시, 전체 채널에서 검색");
        h6.setWidth("max-content");
        buttonPrimary.setText("검색");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutRow5.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow5);
        layoutRow5.addClassName(Gap.MEDIUM);
        layoutRow5.addClassName(Padding.XSMALL);
        layoutRow5.setWidth("100%");
        layoutRow5.getStyle().set("flex-grow", "1");
        layoutRow6.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow6);
        layoutRow6.addClassName(Gap.MEDIUM);
        layoutRow6.setWidth("100%");
        layoutRow6.setHeight("min-content");
        h3.setText("검색 결과");
        h3.setWidth("max-content");
        layoutRow7.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow7);
        layoutRow7.addClassName(Gap.MEDIUM);
        layoutRow7.setWidth("100%");
        layoutRow7.getStyle().set("flex-grow", "1");
        multiSelectGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        multiSelectGrid.setWidth("100%");
        multiSelectGrid.getStyle().set("flex-grow", "0");
        setGridSampleData(multiSelectGrid);
        getContent().add(layoutRow);
        layoutRow.add(textField);
        layoutRow.add(emailField);
        getContent().add(layoutRow2);
        layoutRow2.add(datePicker);
        layoutRow2.add(datePicker2);
        getContent().add(layoutRow3);
        layoutRow3.add(multiSelectComboBox);
        getContent().add(layoutRow4);
        layoutRow4.add(h6);
        getContent().add(buttonPrimary);
        getContent().add(layoutRow5);
        layoutRow5.add(hr);
        getContent().add(layoutRow6);
        layoutRow6.add(h3);
        getContent().add(layoutRow7);
        layoutRow7.add(multiSelectGrid);
        getContent().add(hr2);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setMultiSelectComboBoxSampleData(MultiSelectComboBox multiSelectComboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        multiSelectComboBox.setItems(sampleItems);
        multiSelectComboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;
}
