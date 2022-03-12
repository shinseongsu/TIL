export const requestGetRecentOrders = async () => {
  const response = await fetch("http://localhost:3000/recent-orders", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  });

  const data = await response.json();

  return data;
};

export const requestGetMenuGroups = async () => {
  const response = await fetch("http://localhost:3000/menuGroups", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  });

  const data = await response.json();

  return data;
};

export const requestGetMenu = async (menuId) => {
  const response = await fetch(`http://localhost:3000/menu/${menuId}`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  });

  const data = await response.json();

  return data;
};

export const requestGetMenuOptions = async (menuId) => {
  const response = await fetch(`http://localhost:3000/options/${menuId}`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  });

  const data = await response.json();

  return data;
};
