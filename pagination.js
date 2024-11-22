const paginationContainer = document.getElementById("pagination");

const images = [
  {
    image1: "tap-piltes.jpg",
    image2: "tap-piltes1.jpg",
    image3: "tim-mach.jpg",
    image4: "eat-clean.png",
  },
  {
    image1: "video1.jpg",
    image2: "video2.jpg",
    image3: "video3.jpg",
    image4: "video4.jpg",
  },
  {
    image1: "video2.jpg",
    image2: "tim-mach.jpg",
    image3: "video1.jpg",
    image4: "tap-pilates.jpg",
  },
];
const paginationConfig = {
  currentPage: 1,
  sidePageCount: 1,
  totalPageCount: 5,
  items: 4,
};

function initPagination(paginationConfig, paginationContainer) {
  paginationConfig.container = paginationContainer;
  renderPaginationControls(images, paginationConfig.currentPage, paginationConfig.items, "page");
}

function renderPaginationControls(items, currentPage, itemsPerPage, containerId) {
  const totalPageCount = Math.ceil(items.length / itemsPerPage);
  const paginationList = document.createElement("ul");
  paginationList.classList.add("pagination");

  addNavItem(paginationList, "<<", 1, currentPage === 1);
  addNavItem(paginationList, "<", Math.max(1, currentPage - 1), currentPage === 1);
  addPageNumberItem(paginationList, currentPage, totalPageCount, paginationConfig.sidePageCount);
  addNavItem(paginationList, ">", Math.min(currentPage + 1, totalPageCount), currentPage === totalPageCount);
  addNavItem(paginationList, ">>", totalPageCount, currentPage === totalPageCount);

  paginationConfig.container.innerHTML = "";
  paginationConfig.container.appendChild(paginationList);
}

function addNavItem(parent, navContent, destinationPage, isDisabled) {
  const navItem = createPageNumberItem(navContent, destinationPage, isDisabled);
  parent.appendChild(navItem);
}

function addPageNumberItem(parent, currentPage, totalPageCount, sidePageCount) {
  const range = sidePageCount * 2 + 3;
  const leftPageBoundary = currentPage - sidePageCount;
  const rightPageBoundary = currentPage + sidePageCount;

  for (let page = 1; page <= totalPageCount; page++) {
    const isActive = page === currentPage;
    if (totalPageCount >= range) {
      if (page === 1 || page === totalPageCount || (page >= leftPageBoundary && page <= rightPageBoundary)) {
        parent.appendChild(createPageNumberItem(page, page, isActive));
      } else if (isEllipsisShowed(page, leftPageBoundary, rightPageBoundary)) {
        parent.appendChild(createEllipsisItem());
      }
    } else {
      parent.appendChild(createPageNumberItem(page, page, isActive));
    }
  }
}

function createPageNumberItem(pageItemContent, destinationPage, isActiveOrDisable = false) {
  const pageItem = document.createElement("li");
  pageItem.classList.add("page-item");

  if (isActiveOrDisable) {
    if (typeof pageItemContent === "number") {
      pageItem.classList.add("active");
    } else {
      pageItem.classList.add("disabled");
    }
  }
  const pageLink = document.createElement("a");
  pageLink.classList.add("page-link");
  pageLink.href = `#${destinationPage}`;
  pageLink.textContent = pageItemContent;
  if (!isActiveOrDisable) {
    pageLink.onclick = (event) => {
      event.preventDefault();
      goToPage(destinationPage);
    };
  }
  pageItem.appendChild(pageLink);
  return pageItem;
}

function createEllipsisItem() {
  const ellipsisItem = document.createElement("li");
  ellipsisItem.classList.add("page-item", "disabled");

  const ellipsisLink = document.createElement("span");
  ellipsisLink.classList.add("page-link");
  ellipsisLink.textContent = "...";

  ellipsisItem.appendChild(ellipsisLink);
  return ellipsisItem;
}

function isEllipsisShowed(pagePosition, leftPageBoundary, rightPageBoundary) {
  return (
    pagePosition === leftPageBoundary + 1 ||
    pagePosition === rightPageBoundary - 1
  );
}

function goToPage(page) {
  paginationConfig.currentPage = page;
  renderPage(images, paginationConfig.currentPage, paginationConfig.items, "page");
}

function paginate(items, currentPage, itemsPerPage) {
  const start = (currentPage - 1) * itemsPerPage;
  const end = start + itemsPerPage;
  return items.slice(start, end);
}

function renderPage(items, currentPage, itemsPerPage, containerId) {
  const container = document.getElementById(containerId);
  container.innerHTML = "";

  const paginatedItems = paginate(items, currentPage, itemsPerPage);

  paginatedItems.forEach((imageGroup) => {
    const cardElement = document.createElement("div");
    cardElement.classList.add("card", "mb-3");

    for (const key in imageGroup) {
      const cardBodyElement = document.createElement("div");
      cardBodyElement.classList.add("card-body", "p-0");
      cardBodyElement.innerHTML = `
        <h5 class="card-header text-black">
          Phương pháp Tập Pilates giúp phục hồi chấn thương cột sống
          <span class="p-2 text-secondary"><i class="fa-solid fa-message p-2"></i>16</span>
        </h5>
        <img src="images/${imageGroup[key]}" class="card-img-top w-100" alt="Pilates" />
        <p class="card-text">
          Tuổi trẻ chỉ nghĩ đến, những chuyến đi, đợi mong một ngày được bay nhảy trên những phương trời mới lạ.
          Để rồi những cô đơn mê mãi, tuổi trẻ ấy mới muốn một nơi để trở về.
        </p>
      `;
      cardElement.appendChild(cardBodyElement);
    }

    container.appendChild(cardElement);
  });

  renderPaginationControls(items, currentPage, itemsPerPage, containerId);
}

initPagination(paginationConfig, paginationContainer);
renderPage(images, paginationConfig.currentPage, paginationConfig.items, "page");
