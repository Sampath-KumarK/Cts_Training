import GuestPage from "./GuestPage";
import UserPage from "./UserPage";

function Greeting({ isLoggedIn }) {

  if (isLoggedIn) {
    return <UserPage/>;
  }
  return <GuestPage />;
}

export default Greeting;