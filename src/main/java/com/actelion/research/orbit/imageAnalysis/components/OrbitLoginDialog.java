/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.actelion.research.orbit.imageAnalysis.components;

import com.actelion.research.orbit.imageAnalysis.dal.DALConfig;
import org.jdesktop.swingx.JXLoginPane;
import org.jdesktop.swingx.JXLoginPane.JXLoginDialog;
import org.jdesktop.swingx.JXLoginPane.SaveMode;
import org.jdesktop.swingx.JXLoginPane.Status;
import org.jdesktop.swingx.auth.DefaultUserNameStore;
import org.jdesktop.swingx.auth.LoginService;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class OrbitLoginDialog {

    private static JXLoginPane loginPane = new JXLoginPane(new OrbitLoginService(), null, new PUserNameStore());

    static {
        loginPane.setSaveMode(SaveMode.USER_NAME);
    }

    public static Status showLoginDialog(Frame owner) {
        if (loginPane.getUserNameStore().getUserNames() != null && loginPane.getUserNameStore().getUserNames().length > 0)
            loginPane.setUserName(loginPane.getUserNameStore().getUserNames()[0]);

        JXLoginDialog dialog = new JXLoginDialog(owner, loginPane);
        dialog.setTitle("Orbit Login");
        //KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        //manager.focusNextComponent(loginPane);
        dialog.setVisible(true);

        return dialog.getStatus();
    }

    public static String getUsername() {
        return loginPane.getUserName();
    }

    /**
     * resets the loginPane
     */
    public static void reset() {
        loginPane = new JXLoginPane(new OrbitLoginService(), null, new PUserNameStore());
    }

    private static class OrbitLoginService extends LoginService {
        @Override
        public boolean authenticate(String username, char[] password, String server) throws Exception {
            return DALConfig.getImageProvider().authenticateUser(username, new String(password));
        }

    }


    private static class PUserNameStore extends DefaultUserNameStore {

        public PUserNameStore() {
            loadUserNames();
        }

        @Override
        public void addUserName(String name) {
            List<String> userList = new ArrayList<String>();
            userList.add(name);
            for (String user : getUserNames()) {
                if (!userList.contains(user))
                    userList.add(user);
            }
            setUserNames(userList.toArray(new String[0]));
        }

        @Override
        public boolean containsUserName(String name) {
            return false; // force a addUserName
        }

    }

    public static String getPassword() {
        return new String(loginPane.getPassword());
    }

}
