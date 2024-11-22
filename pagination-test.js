const paginationContainer = document.getElementById("pagination");

const paginationConfig = {
  activePage: 1,
  sidePageCount: 1,
  totalPageCount: 10,
};

function initializePagination(paginationConfig, paginationContainer) {
  paginationConfig.container = paginationContainer;
  renderPaginationControls(paginationConfig);
}

function renderPaginationControls(paginationConfig) {
  const { activePage, totalPageCount, sidePageCount } = paginationConfig;
  const paginationList = document.createElement("ul");
  paginationList.classList.add("pagination");

  addNavigationItem(paginationList, "«", 1, activePage === 1);
  addNavigationItem(paginationList, "‹", Math.max(1, activePage - 1), activePage === 1);

  addPageNumberItems(paginationList, activePage, totalPageCount, sidePageCount);

  addNavigationItem(paginationList, "›", Math.min(totalPageCount, activePage + 1), activePage === totalPageCount);
  addNavigationItem(paginationList, "»", totalPageCount, activePage === totalPageCount);

  paginationConfig.container.innerHTML = "";
  paginationConfig.container.appendChild(paginationList);
}

function addNavigationItem(parent, navigationLabel, destinationPage, isDisabledItem) {
  const navItem = createPageNumberItem(navigationLabel, destinationPage, isDisabledItem);
  parent.appendChild(navItem);
}

function addPageNumberItems(parent, activePage, totalPageCount, sidePageCount) {
  const range = sidePageCount * 2 + 3;
  const leftPageBoundary = activePage - sidePageCount;
  const rightPageBoundary = activePage + sidePageCount;

  for (let page = 1; page <= totalPageCount; page++) {
    const isActive = page === activePage;
    if (totalPageCount >= range) {
      if (page === 1 || page === totalPageCount || (page >= leftPageBoundary && page <= rightPageBoundary)) {
        parent.appendChild(createPageNumberItem(page, page, isActive));
      } else if (isEllipsisNeeded(page, leftPageBoundary, rightPageBoundary)) {
        parent.appendChild(createEllipsis());
      }
    } else {
      parent.appendChild(createPageNumberItem(page, page, isActive));
    }
  }
}

function createPageNumberItem(navigationLabel, destinationPage, isActiveOrDisabled = false) {
  const pageItem = document.createElement("li");
  pageItem.classList.add("page-item");

  if (isActiveOrDisabled) {
    if (typeof navigationLabel === "number") {
      pageItem.classList.add("active");
    } else {
      pageItem.classList.add("disabled");
    }
  }

  const pageLink = document.createElement("a");
  pageLink.classList.add("page-link");
  pageLink.href = "#";
  pageLink.textContent = navigationLabel;
  if (!isActiveOrDisabled) {
    pageLink.onclick = (event) => {
      event.preventDefault();
      navigateToPage(destinationPage);
    };
  }

  pageItem.appendChild(pageLink);
  return pageItem;
}

function createEllipsis() {
  const ellipsisItem = document.createElement("li");
  ellipsisItem.classList.add("page-item", "disabled");

  const ellipsisLink = document.createElement("span");
  ellipsisLink.classList.add("page-link");
  ellipsisLink.textContent = "...";

  ellipsisItem.appendChild(ellipsisLink);
  return ellipsisItem;
}

function isEllipsisNeeded(pagePosition, leftPageBoundary, rightPageBoundary) {
  return pagePosition === leftPageBoundary + 1 || pagePosition === rightPageBoundary - 1;
}

function navigateToPage(page) {
  paginationConfig.activePage = page;
  renderPaginationControls(paginationConfig);
}

initializePagination(paginationConfig, paginationContainer);