LABEL = wine-jdk8-32:2018-11-11
ARCHIVE="wine-jdk8-32"

.PHONY: help
help:
	@echo "build      - image $(LABEL)"
	@echo "save-image - to $(ARCHIVE).tar.gz"
	@echo "load-image - from $(ARHIVE).tar.gz"

.PHONY: build
build:
	docker build . -t $(LABEL)

save-image:
	docker save $(LABEL) > $(ARCHIVE).tar
	gzip $(ARCHIVE).tar

load-image:
	gunzip $(ARCHIVE).tar.gz
	docker load < $(LABEL).tar