public class Login {

        private String userName;
        private String password;
        private String position;

        public Login(String userName, String password , String position) {

            this.userName = userName;
            this.password = password;
            this.position = position;
        }

        public String getUserName(){
            return userName;
        }

        public void setUserName(String userName){
            this.userName = userName;
        }

        public String getPassword(){
            return password;
        }

        public void setPassword(String password){
            this.password = password;
        }

        public String getPosition(){
            return position;
        }

        public void setPosition(String position){
            this.position = position;
        }

        public boolean isValidUserName(String userName) {
            if (userName == null) {
                return false;
            }
            return this.userName != null && this.userName.equals(userName);
        }

        public boolean isValidPassword(String password) {
            if (password == null) {
                return false;
            }
            return this.password != null && this.password.equals(password);
        }

        @Override
        public String toString() {
            return "User Name : " + this.userName+"\n" + "Password : " + this.password+"\n" + "Position : " + this.position+"\n";

        }


}
