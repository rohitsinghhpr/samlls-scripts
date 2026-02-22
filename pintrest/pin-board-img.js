// Create a Set to store unique image URLs
const imageSet = new Set();

// Function to extract image URLs using XPath
function extractImages() {
    const xpath = `//div[@data-test-id="board-feed"]//div[@data-grid-item="true"]//img`;

    const result = document.evaluate(
        xpath,
        document,
        null,
        XPathResult.ORDERED_NODE_SNAPSHOT_TYPE,
        null
    );

    for (let i = 0; i < result.snapshotLength; i++) {
        const img = result.snapshotItem(i);
        if (img && img.src) {
            imageSet.add(img.src);
        }
    }

    console.log("Current unique images count:", imageSet.size);
}

// Function to auto-scroll and keep extracting
async function autoScrollAndExtract() {
    let lastHeight = 0;

    while (true) {
        extractImages();

        window.scrollTo(0, document.body.scrollHeight);

        await new Promise(resolve => setTimeout(resolve, 2000));

        const newHeight = document.body.scrollHeight;

        if (newHeight === lastHeight) {
            console.log("Scrolling finished.");
            break;
        }

        lastHeight = newHeight;
    }

    console.log("Final Image URLs Set:");
    console.log(imageSet);
}

// Start the process
autoScrollAndExtract();
