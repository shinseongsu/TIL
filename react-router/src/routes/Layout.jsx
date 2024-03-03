import {Outlet, Link, NavLink, useResolvedPath, useMatch} from "react-router-dom";

export default function Layout() {
  return (
    <div>
      <h1>Basic Example</h1>
      <nav>
        <ul>
          <li>
            <NavLink to="/">Home</NavLink>
          </li>
          <li>
            <NavLink to="/about" className={({isActive}) => (isActive ? "activeClass": "")}>About</NavLink>
          </li>
          <li>
            <NavLink to="/dashboard"
              style={({isActive}) => ({
                color: isActive ? 'pink' : ''
              })}
            >Dashboards</NavLink>
          </li>
          <li>
            <Link to="/nothing-here">Nothing Here</Link>
          </li>
          <li>
            <CustomLink to="/login">Login</CustomLink>
          </li>
          <li>
            <Link to="/logout">Logout</Link>
          </li>
          <li>
            <NavLink to="/team/123" end>{({isActive}) => {
              if(isActive) {
                return "Team 123 (active)"
              }
              return "Team 123"
            }}
            </NavLink>
          </li>
          <li>
            <NavLink to="/team/New" caseSensitive>New Team</NavLink>
          </li>
          <li>
            <Link to="/team/123/task/456">Team 123 Task 456</Link>
          </li>
        </ul>
      </nav>
      <Outlet />
    </div>
  );
}

function CustomLink({children, to, ...props}) {
  const resolved = useResolvedPath(to);
  const match = useMatch({path: resolved.pathname, end: true})

  return (
      <div>
        <Link to={to} {...props}>
          {children}
        </Link>
        {match && "(match!)"}
      </div>
  )
}