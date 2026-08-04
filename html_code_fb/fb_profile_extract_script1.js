const profiles = [];

document.querySelectorAll(
  'div.x78zum5.xdt5ytf[data-virtualized="false"]'
).forEach(parent => {
  const link = parent.querySelector('a[role="presentation"]');
  if (!link) return;

  // Get profile image
  let profileImg = "";

  const img = parent.querySelector("img");
  if (img) {
    profileImg = img.src;
  } else {
    const image = parent.querySelector('svg[role="img"] image');
    if (image) {
      profileImg =
        image.getAttribute("href") ||
        image.getAttribute("xlink:href") ||
        "";
    }
  }

  profiles.push({
    "profile-url": link.href,
    "user-name": link.innerText.trim(),
    "profile-img": profileImg
  });
});

console.log(JSON.stringify(profiles, null, 2));