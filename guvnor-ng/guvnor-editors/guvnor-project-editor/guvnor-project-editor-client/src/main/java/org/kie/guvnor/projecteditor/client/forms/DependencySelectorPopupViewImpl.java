package org.kie.guvnor.projecteditor.client.forms;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextHeader;
import com.google.gwt.user.client.ui.Widget;
import org.jboss.errai.ioc.client.api.Caller;
import org.kie.guvnor.m2repo.client.editor.PagedJarTable;
import org.kie.guvnor.m2repo.model.JarListPageRow;
import org.kie.guvnor.m2repo.service.M2RepoService;
import org.uberfire.client.common.Popup;

import javax.inject.Inject;

public class DependencySelectorPopupViewImpl
        extends Popup
        implements DependencySelectorPopupView {

    private final Caller<M2RepoService> m2RepoService;

    @Inject
    public DependencySelectorPopupViewImpl(Caller<M2RepoService> m2RepoService) {
        this.m2RepoService = m2RepoService;
    }

    @Override
    public Widget getContent() {
        PagedJarTable pagedJarTable = new PagedJarTable(m2RepoService);
        pagedJarTable.hideColumnPicker();
        pagedJarTable.hideSelectionColumn();

        Column<JarListPageRow, String> selectColumn = new Column<JarListPageRow, String>(new ButtonCell()) {
            public String getValue(JarListPageRow row) {
                return "Select";
            }
        };
        selectColumn.setFieldUpdater(new FieldUpdater<JarListPageRow, String>() {
            public void update(int index,
                               JarListPageRow row,
                               String value) {
                //TODO
            }
        });

        pagedJarTable.addColumn(selectColumn, new TextHeader(""));

        return pagedJarTable;
    }
}
